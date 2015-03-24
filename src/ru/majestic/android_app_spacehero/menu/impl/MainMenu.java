package ru.majestic.android_app_spacehero.menu.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;

import android.util.Log;

import ru.majestic.android_app_spacehero.menu.IGameMenu;
import ru.majestic.android_app_spacehero.menu.listeners.GameMenuVisibleListener;
import ru.majestic.android_app_spacehero.resources.ResourceManager;

public class MainMenu extends Entity implements IGameMenu, OnClickListener {   
   
   private static final String LOG_TAG = MainMenu.class.getSimpleName();
   
//   private Sprite       logoTxt;
   private ButtonSprite startButton;
   //Mute/unmute music button
   //Mute/unmute sound button
   
   private boolean   menuVisible;
   
   public MainMenu(float menuWidth, float menuHeight) {
      initViews(menuWidth, menuHeight);
      
      this.menuVisible = false;
   }
   
   private void initViews(float menuWidth, float menuHeight) {
      startButton = new ButtonSprite(0, 0, ResourceManager.getInstance().getStartGameBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      startButton.setVisible  (false);
      startButton.setWidth    (menuWidth * 0.8f);
      startButton.setHeight   (menuHeight * 0.1f);
      startButton.setX        ((menuWidth - startButton.getWidth()) / 2);
      startButton.setY        (menuHeight * 0.7f);
      
      startButton.setOnClickListener(this);         
      
      attachChild(startButton);
   }      
   
   @Override
   public void show(Scene scene) {
      scene.registerTouchArea(startButton);
      
      startButton.setVisible(true);
   }

   @Override
   public void hide() {
      startButton.setVisible(false);
      
   }
   
   @Override
   public boolean isMenuVisible() {
      return menuVisible;
   }

   @Override
   public void addGameMenuVisibleListener(GameMenuVisibleListener gameMenuVisibleListener) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void removeGameMenuVisibleListener(GameMenuVisibleListener gameMenuVisibleListener) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {
      if(pButtonSprite == startButton) {
         Log.i(LOG_TAG, "Start btn clicked");
      }
   }   

}
