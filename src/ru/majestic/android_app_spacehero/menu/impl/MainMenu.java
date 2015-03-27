package ru.majestic.android_app_spacehero.menu.impl;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;

import ru.majestic.android_app_spacehero.menu.GameMenuSkeleton;
import ru.majestic.android_app_spacehero.menu.animation.GameMenuAnimator;
import ru.majestic.android_app_spacehero.menu.animation.main.LogoTxtHideAnim;
import ru.majestic.android_app_spacehero.menu.animation.main.LogoTxtShowAnim;
import ru.majestic.android_app_spacehero.menu.animation.main.StartGameButtonHideAnim;
import ru.majestic.android_app_spacehero.menu.animation.main.StartGameButtonShowAnim;
import ru.majestic.android_app_spacehero.menu.listeners.MainMenuOnButtonsClickedListeners;
import ru.majestic.android_app_spacehero.resources.ResourceManager;

public class MainMenu extends GameMenuSkeleton implements OnClickListener {   
   
   private Sprite       logoTxt;
   private ButtonSprite startButton;
   //Mute/unmute music button
   //Mute/unmute sound button        
   
   private MainMenuOnButtonsClickedListeners mainMenuOnButtonsClickedListeners;   
   
   public MainMenu(Camera camera) {
      super(camera);                  
   }
   
   @Override
   protected void initMenuElements() {
      startButton    = new ButtonSprite(-999, -999, ResourceManager.getInstance().getStartGameBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      logoTxt        = new Sprite(-999, -999, ResourceManager.getInstance().getLogoTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      startButton.setWidth    (camera.getWidth() * 0.8f);
      startButton.setHeight   (camera.getHeight() * 0.1f);
      startButton.setX        ((camera.getWidth() - startButton.getWidth()) / 2);
      
      logoTxt.setWidth        (camera.getWidth() * 0.8f);
      logoTxt.setHeight       (camera.getHeight() * 0.1f);
      logoTxt.setX            ((camera.getWidth() - logoTxt.getWidth()) / 2);
      
      registerTouchArea(startButton);
      
      startButton.setOnClickListener(this);         
      
      attachChild(startButton);      
      attachChild(logoTxt);
   }
   
   @Override
   protected void initShowElementsModifiers(GameMenuAnimator gameMenuAnimator) {
      gameMenuAnimator.addShowAnimation(new StartGameButtonShowAnim(startButton, camera.getHeight() * 0.7f));
      gameMenuAnimator.addShowAnimation(new LogoTxtShowAnim(logoTxt, camera.getHeight() * 0.2f));
   }

   @Override
   protected void initHideElementsModifiers(GameMenuAnimator gameMenuAnimator) {
      gameMenuAnimator.addHideAnimation(new StartGameButtonHideAnim(startButton, camera.getHeight() * 0.7f));
      gameMenuAnimator.addHideAnimation(new LogoTxtHideAnim(logoTxt, camera.getHeight() * 0.2f));
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
