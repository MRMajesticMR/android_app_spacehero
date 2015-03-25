package ru.majestic.android_app_spacehero.menu.impl;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;

import ru.majestic.android_app_spacehero.menu.GameMenuSkeleton;
import ru.majestic.android_app_spacehero.menu.listeners.MainMenuOnButtonsClickedListeners;
import ru.majestic.android_app_spacehero.resources.ResourceManager;

public class MainMenu extends GameMenuSkeleton implements OnClickListener {   
   
   private static final String LOG_TAG = MainMenu.class.getSimpleName();      
   
   //Logo sprite
   private ButtonSprite startButton;
   //Mute/unmute music button
   //Mute/unmute sound button
   
   private MainMenuOnButtonsClickedListeners mainMenuOnButtonsClickedListeners;
   
   
   public MainMenu(Camera camera) {
      super(camera);
   }
   
   @Override
   protected void initMenuElements() {
      startButton = new ButtonSprite(0, 0, ResourceManager.getInstance().getStartGameBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      startButton.setWidth    (camera.getWidth() * 0.8f);
      startButton.setHeight   (camera.getHeight() * 0.1f);
      startButton.setX        ((camera.getWidth() - startButton.getWidth()) / 2);
      startButton.setY        (camera.getHeight() * 0.7f);
      
      registerTouchArea(startButton);
      
      startButton.setOnClickListener(this);         
      
      attachChild(startButton);      
   }           
   
   @Override
   public void show() {            
      camera.setHUD(this);           
      
      notifyGameMenuVisibleListenersOnShow();
   }

   @Override
   public void hide() {
      
      notifyGameMenuVisibleListenersOnHide();
   }            

   public void setMainMenuOnButtonsClickedListeners(MainMenuOnButtonsClickedListeners mainMenuOnButtonsClickedListeners) {
      this.mainMenuOnButtonsClickedListeners = mainMenuOnButtonsClickedListeners;
   }

   @Override
   public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {
      if(pButtonSprite == startButton) {
         mainMenuOnButtonsClickedListeners.onStartButtonClicked();
      }
   }     

}
