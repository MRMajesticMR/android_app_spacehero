package ru.majestic.android_app_spacehero.menu.impl;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;

import ru.majestic.android_app_spacehero.menu.GameMenuSkeleton;
import ru.majestic.android_app_spacehero.menu.animation.listeners.OnAnimationEndListener;
import ru.majestic.android_app_spacehero.menu.animation.main.StartGameButtonShowAnim;
import ru.majestic.android_app_spacehero.menu.listeners.MainMenuOnButtonsClickedListeners;
import ru.majestic.android_app_spacehero.resources.ResourceManager;

public class MainMenu extends GameMenuSkeleton implements OnClickListener, OnAnimationEndListener {   
   
   private static final String LOG_TAG = MainMenu.class.getSimpleName();      
   
   //Logo sprite
   private ButtonSprite startButton;
   //Mute/unmute music button
   //Mute/unmute sound button
   
   private StartGameButtonShowAnim startButtonShowAnim;
   
   private MainMenuOnButtonsClickedListeners mainMenuOnButtonsClickedListeners;   
   
   public MainMenu(Camera camera) {
      super(camera);
      
      startButtonShowAnim = new StartGameButtonShowAnim(startButton, camera.getHeight() * 2, camera.getHeight() * 0.7f);
      startButtonShowAnim.setOnAnimationEndListener(this);
   }
   
   @Override
   protected void initMenuElements() {
      startButton = new ButtonSprite(0, 0, ResourceManager.getInstance().getStartGameBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      startButton.setWidth    (camera.getWidth() * 0.8f);
      startButton.setHeight   (camera.getHeight() * 0.1f);
      startButton.setX        ((camera.getWidth() - startButton.getWidth()) / 2);
      startButton.setY        (camera.getHeight() * 2);
      
      registerTouchArea(startButton);
      
      startButton.setOnClickListener(this);         
      
      attachChild(startButton);      
   }           
   
   @Override
   public void show() {      
      camera.setHUD(this);
      
      startButtonShowAnim.start();                        
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
   
   @Override
   public void onAnimationEnd() {
      notifyGameMenuVisibleListenersOnShow();
   }

}
