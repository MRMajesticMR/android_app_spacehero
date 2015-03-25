package ru.majestic.android_app_spacehero.menu.impl;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;

import ru.majestic.android_app_spacehero.menu.GameMenuSkeleton;
import ru.majestic.android_app_spacehero.resources.ResourceManager;

public class PauseGameMenu extends GameMenuSkeleton implements OnClickListener {

   private ButtonSprite    resumeButton;
   private ButtonSprite    exitButton;
   
   public PauseGameMenu(Camera camera) {
      super(camera);
   }

   @Override
   protected void initMenuElements() {
      
      resumeButton = new ButtonSprite(0, 0, ResourceManager.getInstance().getPauseGameBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      resumeButton.setWidth    (camera.getWidth() * 0.4f);
      resumeButton.setHeight   (camera.getHeight() * 0.1f);
      resumeButton.setX        (camera.getWidth() * 0.05f);
      resumeButton.setY        (camera.getHeight() * 0.7f);
      
      exitButton = new ButtonSprite(0, 0, ResourceManager.getInstance().getPauseGameBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      exitButton.setWidth    (camera.getWidth() * 0.4f);
      exitButton.setHeight   (camera.getHeight() * 0.1f);
      exitButton.setX        (camera.getWidth() * 0.55f);
      exitButton.setY        (camera.getHeight() * 0.7f);
      
      registerTouchArea(resumeButton);
      registerTouchArea(exitButton);      
      
      resumeButton.setOnClickListener(this);
      exitButton.setOnClickListener(this);
      
      attachChild(resumeButton);
      attachChild(exitButton);
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

   @Override
   public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {
      
   }

}
