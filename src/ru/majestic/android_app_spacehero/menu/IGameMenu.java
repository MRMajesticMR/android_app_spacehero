package ru.majestic.android_app_spacehero.menu;

import org.andengine.entity.scene.Scene;

import ru.majestic.android_app_spacehero.menu.listeners.GameMenuVisibleListener;

public interface IGameMenu {

   public void       show           ();
   public void       hide           ();   
   public boolean    isMenuVisible  ();
   
   public void addGameMenuVisibleListener    (GameMenuVisibleListener gameMenuVisibleListener);
   public void removeGameMenuVisibleListener (GameMenuVisibleListener gameMenuVisibleListener);
   
}
