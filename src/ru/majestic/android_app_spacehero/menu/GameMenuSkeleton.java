package ru.majestic.android_app_spacehero.menu;

import java.util.ArrayList;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;

import ru.majestic.android_app_spacehero.menu.animation.GameMenuAnimator;
import ru.majestic.android_app_spacehero.menu.animation.GameMenuAnimator.OnMenuVisibleChangedListener;
import ru.majestic.android_app_spacehero.menu.listeners.GameMenuVisibleListener;
import android.util.Log;

public abstract class GameMenuSkeleton extends HUD implements IGameMenu, OnMenuVisibleChangedListener {

   private static final String LOG_TAG = GameMenuSkeleton.class.getSimpleName();
   
   private ArrayList<GameMenuVisibleListener> gameMenuVisibleListeners = new ArrayList<GameMenuVisibleListener>();
   
   private              boolean           menuVisible;
   protected   final    Camera            camera;   
   private     final    GameMenuAnimator  gameMenuAnimator;
   
   public GameMenuSkeleton(Camera camera) {
      this.camera       = camera;
      this.menuVisible  = false;
      
      gameMenuAnimator = new GameMenuAnimator();
      gameMenuAnimator.setOnMenuVisibleChangedListener(this);
      
      initMenuElements();
      initShowElementsModifiers(gameMenuAnimator);
      initHideElementsModifiers(gameMenuAnimator);
   }
   
   protected abstract void initMenuElements           ();
   protected abstract void initShowElementsModifiers  (GameMenuAnimator gameMenuAnimator);
   protected abstract void initHideElementsModifiers  (GameMenuAnimator gameMenuAnimator);

   @Override
   public void show() {      
      camera.setHUD(this);
      
      gameMenuAnimator.show();
   }

   @Override
   public void hide() {
      gameMenuAnimator.hide();      
   }

   @Override
   public boolean isMenuVisible() {
      return menuVisible;
   }

   @Override
   public void addGameMenuVisibleListener(GameMenuVisibleListener gameMenuVisibleListener) {
      if(gameMenuVisibleListeners.contains(gameMenuVisibleListener)) {
         Log.e(LOG_TAG, "Listeners already added.");
      } else {
         gameMenuVisibleListeners.add(gameMenuVisibleListener);
      }
   }

   @Override
   public void removeGameMenuVisibleListener(GameMenuVisibleListener gameMenuVisibleListener) {
      if(gameMenuVisibleListeners.contains(gameMenuVisibleListener)) {
         gameMenuVisibleListeners.remove(gameMenuVisibleListener);
      } else {
         Log.e(LOG_TAG, "Listeners not added.");         
      }      
   }
   
   protected void notifyGameMenuVisibleListenersOnHide() {
      for(GameMenuVisibleListener listener: gameMenuVisibleListeners)
         listener.onMenuHide();
   }
   
   protected void notifyGameMenuVisibleListenersOnShow() {
      for(GameMenuVisibleListener listener: gameMenuVisibleListeners)
         listener.onMenuShow();
   }
   
   @Override
   public void onShowMenuAnimationEnd() {
      notifyGameMenuVisibleListenersOnShow();
   }

   @Override
   public void onHideMenuAnimationEnd() {
      notifyGameMenuVisibleListenersOnHide();
   }

}
