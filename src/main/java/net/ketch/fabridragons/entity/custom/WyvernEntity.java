package net.ketch.fabridragons.entity.custom;

import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.ketch.fabridragons.entity.ModEntities;
import net.ketch.fabridragons.entity.client.init.WyvernKeybinds;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.util.math.*;
import net.minecraft.client.MinecraftClient;


import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import java.util.UUID;

public class WyvernEntity extends TameableEntity implements GeoEntity {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    //from horse code
    private UUID ownerUuid;
    private boolean SADDLED = false; //init to false, obviously
    protected boolean inAir;

    protected int maxGroundDuration;
    protected int groundCounter;


    public WyvernEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.maxGroundDuration = 5000;
        this.groundCounter = 0;

    }

    public static DefaultAttributeContainer.Builder createWyvernAttributes() {
        return TameableEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 50)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f) //might have to update
                .add(EntityAttributes.GENERIC_ARMOR, 3.0f)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 1.0f) //may cause bug
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5);


    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this)); //HAS to be primary goal or entity will drown lol
        this.goalSelector.add(1, new SitGoal(this));

        //racism is fun
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, VillagerEntity.class, true));

        this.goalSelector.add(2, new AnimalMateGoal(this, 1.150));
        this.goalSelector.add(3, new TemptGoal(this, 2.30D, Ingredient.ofItems(Items.ENDER_EYE), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.150));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.150));

    }

    public static final TrackedData<Boolean> MOVE_FORWARD_PRESSED = DataTracker.registerData(WyvernEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final TrackedData<Boolean> MOVE_BACK_PRESSED = DataTracker.registerData(WyvernEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final TrackedData<Boolean> JUMP_PRESSED = DataTracker.registerData(WyvernEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final TrackedData<Boolean> MOVE_DOWN_PRESSED = DataTracker.registerData(WyvernEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final TrackedData<Boolean> IS_FLYING = DataTracker.registerData(WyvernEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public void updateInputs(boolean forward, boolean back, boolean jump, boolean down) {
        dataTracker.set(MOVE_FORWARD_PRESSED, forward);
        dataTracker.set(MOVE_BACK_PRESSED, back);
        dataTracker.set(JUMP_PRESSED, jump);
        dataTracker.set(MOVE_DOWN_PRESSED, down);
    }

    public boolean isMoveForwardPressed() {
        return dataTracker.get(MOVE_FORWARD_PRESSED);
    }

    public boolean isMoveBackPressed() {
        return dataTracker.get(MOVE_BACK_PRESSED);
    }

    public boolean isJumpPressed() {
        return dataTracker.get(JUMP_PRESSED);
    }

    public boolean isDownPressed() {
        return dataTracker.get(MOVE_DOWN_PRESSED);
    }


    @Override
    public void tick() {
        super.tick();
        LivingEntity rider; //passenger controlling the dragon is "rider"
        rider = getControllingPassenger();

        if (getWorld().isClient() && rider == MinecraftClient.getInstance().player) {
            boolean isMoveForwardPressed = MinecraftClient.getInstance().options.forwardKey.isPressed();
            boolean isJumpPressed = MinecraftClient.getInstance().options.jumpKey.isPressed();
            boolean isMoveBackPressed = MinecraftClient.getInstance().options.backKey.isPressed();
            boolean isDownPressed = WyvernKeybinds.downKey.isUnbound() ? false : WyvernKeybinds.downKey.isPressed();

            //keep dragon moving relative to player view, NOT world map
            float riderYaw = rider.getYaw();
            double radians = Math.toRadians(riderYaw);
            double forwardX = -Math.sin(radians);
            double forwardZ = Math.cos(radians);

            if (isMoveForwardPressed() && this.isInAir()) {
                // Move the wyvern forward
                this.addVelocity(forwardX * 0.2, 0, forwardZ * 0.2);  // Adjust velocity as needed
            }
            if (isMoveForwardPressed() && !this.isInAir()) {
                // Move the wyvern forward
                this.addVelocity(forwardX * 0.15, 0, forwardZ * 0.15);  // Adjust velocity as needed
            }
            if (isMoveBackPressed() && this.isInAir()) {
                // Move the wyvern backward
                this.addVelocity(-forwardX * 0.1, 0, -forwardZ * 0.1);
            }
            if (isMoveBackPressed() && !this.isInAir()) {
                // Move the wyvern backward
                this.addVelocity(-forwardX * 0.1, 0, -forwardZ * 0.1);
            }
            if (isJumpPressed()) {
                // Ascend
                this.addVelocity(0, 0.08, 0);
                this.setInAir(true, true); //maybe this will let it fly
            }
            if (isDownPressed()) {
                // Descend
                this.addVelocity(0, -0.1, 0);
            }
            updateInputs(isMoveForwardPressed, isMoveBackPressed, isJumpPressed, isDownPressed);
            updateWyvernRotation((PlayerEntity) rider);

            this.setYaw(riderYaw);
            this.setPitch(rider.getPitch());

            if (this.isOnGround()){
                this.setInAir(false, false);
            }
        }
        if (rider == null) updateInputs(false, false, false, false);
    }

    public boolean canBeControlledByRider() {
        return getControllingPassenger() instanceof PlayerEntity;
    }

    //submissive AND breedable! :3
    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.WYVERN.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }


    //when to play each animation
    private <E extends GeoAnimatable> PlayState predicate(AnimationState tAnimationState) {
        if(this.isInAir() && isMoveForwardPressed() && isDownPressed()){
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("dive", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        if(this.isInAir() && isMoveBackPressed() && !isMoveForwardPressed()){
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("hover", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        if (this.isInAir() && tAnimationState.isMoving()) { //probably doesn't work
            //edit holy shit it does
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("flap", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        if(this.isInAir() && !tAnimationState.isMoving()){
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("hover", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        if (tAnimationState.isMoving() && !this.isInAir()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        if (this.isSitting()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("sit", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        //default state, should always be doing this, never fully static/t pose.  might crash otherwise?
        tAnimationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }


    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    // I THINK I can leave this because breeding item
    @Nullable
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.ENDER_EYE);
    }

    /*TAMEABLE ENTITY */
    private static final TrackedData<Boolean> SITTING =
            DataTracker.registerData(WyvernEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        Item item = itemstack.getItem();
        Item itemForTaming = Items.RAW_GOLD;

        if (item == itemForTaming && !isTamed()) {
            if (this.getWorld().isClient()) {
                return ActionResult.CONSUME; //consume gold to tame
            } else {
                if (!player.getAbilities().creativeMode) {
                    itemstack.decrement(1); //don't consume gold if creative
                }

                if (!this.getWorld().isClient()) {
                    super.setOwner(player);  //setowner to be player, not sure if entity becomes private to player
                    this.setOwnerUuid(player.getUuid());
                    this.navigation.recalculatePath();
                    this.setTarget(null);
                    this.getWorld().sendEntityStatus(this, (byte) 7);  //spawn tame particles?
                    setSit(true);
                }
                return ActionResult.SUCCESS;
            }
        }

        if (isTamed() && player.getUuid() == ownerUuid && !this.getWorld().isClient() && hand == Hand.MAIN_HAND) {
            this.putPlayerOnBack(player);
            this.isSaddled(); //using saddled to mean "rideable".
            return ActionResult.success(this.getWorld().isClient);
        }

        //set dragon to sit
        if (isTamed() && !this.getWorld().isClient() && item == Items.STICK) {
            if (!this.isSitting()) {
                this.setSit(true);
            } else {
                this.setSit(false);
            }
            return ActionResult.SUCCESS;
        }

        //tame dragon if holding correct item
        if (itemstack.getItem() == itemForTaming) {
            return ActionResult.PASS;
        }
        return super.interactMob(player, hand);
    }

    public void setSit(boolean sitting) {
        this.dataTracker.set(SITTING, sitting);
        super.setSitting(sitting);
    }

    public boolean isSitting() {
        return this.dataTracker.get(SITTING);
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        if (tamed) {
            getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(60.0D);
            getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(4D);
            getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue((double) 2.0f);
        } else {
            getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(30.0D);
            getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(2D);
            getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue((double) 0.25f);
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("isSitting", this.dataTracker.get(SITTING));
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(SITTING, nbt.getBoolean("isSitting"));
    }

    //what is this for
    @Override
    public Team getScoreboardTeam() {
        return super.getScoreboardTeam();  //no idea what the fuck this is
    }

    public boolean canBeLeashedBy(PlayerEntity player) {
        return true; //was false but why not
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(SITTING, false);
        this.dataTracker.startTracking(MOVE_FORWARD_PRESSED, false);
        this.dataTracker.startTracking(MOVE_BACK_PRESSED, false);
        this.dataTracker.startTracking(JUMP_PRESSED, false);
        this.dataTracker.startTracking(MOVE_DOWN_PRESSED, false);
    }

    @Override
    public EntityView method_48926() {
        return super.getWorld(); //someone on github said to try this
        //it worked, this is the stupidest thing i have ever seen
    }

    /*RIDEABLE ENTITY*/
    public boolean isSaddled() {
        return true; //want to be "saddled" all the time I think, so we can ride it regardless
    }

    protected void putPlayerOnBack(PlayerEntity player) {
        if (!this.getWorld().isClient) {
            player.setYaw(this.getYaw());
            player.setPitch(this.getPitch());
            player.startRiding(this);

        }
    }

    @Nullable
    public UUID getOwnerUuid() {
        return this.ownerUuid;
    }

    public void setOwnerUuid(@Nullable UUID ownerUuid) {
        this.ownerUuid = ownerUuid;
    }

    //needed for tickControlled
    public void setInAir(boolean inAir, boolean gravity) {
        this.inAir = inAir;
        this.setNoGravity(gravity);
    }

    //need for flying
    public boolean isInAir() {
        return this.inAir;
    }

    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
        if (this.isSaddled()) {
            Entity var2 = this.getFirstPassenger();
            if (var2 instanceof PlayerEntity) {
                return (PlayerEntity) var2;
            }
        }
        return super.getControllingPassenger();
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
            return false; //      fall damage'nt
    }

    //might want this in order to control movement with mouse angel?
    public void updateTrackedHeadRotation(float yaw, int interpolationSteps) {
        this.setHeadYaw(yaw);
    }

    //make sure wyvern stays oriented with the player
    public void updateWyvernRotation(PlayerEntity player) {
        this.setBodyYaw(player.getBodyYaw());
    }
}
