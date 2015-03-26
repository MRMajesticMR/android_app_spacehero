package ru.majestic.android_app_spacehero.menu.impl;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;

import ru.majestic.android_app_spacehero.menu.GameMenuSkeleton;
import ru.majestic.android_app_spacehero.menu.listeners.PlayMenuOnButtonsClickedListener;
import ru.majestic.android_app_spacehero.menu.tutorial.Tutorial;
import ru.majestic.android_app_spacehero.resources.ResourceManager;

public class PlayMenu extends GameMenuSkeleton implements OnClickListener {

   //Score
   //Sheep control panel
   private ButtonSprite    pauseButton;
   private Tutorial        tutorial;
   
   private PlayMenuOnButtonsClickedListener playMenuOnButtonsClickedListener;
   
   public PlayMenu(Camera camera) {
      super(camera);
   }   
   
   @Override
   protected void initMenuElements() {
      pauseButton = new ButtonSprite(0, 0, ResourceManager.getInstance().getPauseGameBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      pauseButton.setWidth    (40.0f);
      pauseButton.setHeight   (40.0f);
      pauseButton.setX        (camera.getWidth() - pauseButton.getWidth() - 10);
      pauseButton.setY        (10);
      
      registerTouchArea(pauseButton);
      
      pauseButton.setOnClickListener(this);         
      
      attachChild(pauseButton); 
   }
   
   private boolean isLaunchedFirstTime() {
      return false;
   }
   
   @Override
   public void show() {
      camera.setHUD(this);
      
      if(isLaunchedFirstTime()) {
         tutorial = new Tutorial(camera.getWidth(), camera.getHeight());         
         attachChild(tutorial);
         tutorial.show();
      }
      
      notifyGameMenuVisibleListenersOnShow();
   }

   @Override
   public void hide() {
      notifyGameMenuVisibleListenersOnHide();
   }     

   public void setPlayMenuOnButtonsClickedListener(PlayMenuOnButtonsClickedListener playMenuOnButtonsClickedListener) {
      this.playMenuOnButtonsClickedListener = playMenuOnButtonsClickedListener;
   }

   @Override
   public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {
      if(pButtonSprite == pauseButton) {
         playMenuOnButtonsClickedListener.onPauseButtonClicked();
      }
      
   }   

}
