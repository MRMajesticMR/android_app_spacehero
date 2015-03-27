package ru.majestic.android_app_spacehero.game.user;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.IEntity;
import org.andengine.entity.sprite.Sprite;

import ru.majestic.android_app_spacehero.resources.ResourceManager;

public class UserSpaceship implements IUpdateHandler {

   private static final float SPACESHIP_WIDTH   = 50;
   private static final float SPACESHIP_HEIGHT  = 80;   
   
   private static final float DEFAULT_TURN_SPEED = 5;
   
   private Sprite spaceshipView;
   
   private TurnState    currentTurnState;
   private float        turnSpeed;
   
   public UserSpaceship() {
      spaceshipView = new Sprite(-999, -999, SPACESHIP_WIDTH, SPACESHIP_HEIGHT, ResourceManager.getInstance().getUserSpaceshipTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      currentTurnState  = TurnState.NONE;
      turnSpeed         = DEFAULT_TURN_SPEED;
   }
   
   public void changeTurnState(TurnState turnState) {
      this.currentTurnState = turnState;
   }
   
   public TurnState getTurnState() {
      return currentTurnState;
   }
   
   public void setX(float x) {
      spaceshipView.setX(x);
   }
   
   public void setY(float y) {
      spaceshipView.setY(y);
   }
   
   public float getX() {
      return spaceshipView.getX();
   }
   
   public float getY() {
      return spaceshipView.getY();
   }
   
   public float getWidth() {
      return spaceshipView.getWidth();
   }
   
   public float getHeight() {
      return spaceshipView.getHeight();
   }
   
   public void attachTo(IEntity entity) {
      entity.attachChild(spaceshipView);
      
      spaceshipView.registerUpdateHandler(this);
   }

   @Override
   public void onUpdate(float pSecondsElapsed) {
      switch(currentTurnState) {
      case LEFT:
         setX(getX() - turnSpeed);
         break;
      case RIGHT:
         setX(getX() + turnSpeed);
         break;
      case NONE:
         break;
      }
   }

   @Override
   public void reset() {
      //???
      
   }
   
}
