package ru.majestic.android_app_spacehero.menu;

import java.util.ArrayList;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;

import android.util.Log;

import ru.majestic.android_app_spacehero.menu.listeners.GameMenuVisibleListener;

public abstract class GameMenuSkeleton extends HUD implements IGameMenu {

   private static final String LOG_TAG = GameMenuSkeleton.class.getSimpleName();
   
   private ArrayList<GameMenuVisibleListener> gameMenuVisibleListeners = new ArrayList<GameMenuVisibleListener>();
   
   private              boolean   menuVisible;
   protected   final    Camera    camera;
   
   public GameMenuSkeleton(Camera camera) {
      this.camera       = camera;
      this.menuVisible  = false;
      
      initMenuElements();
   }
   
   protected abstract void initMenuElements();


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

}
