package ru.majestic.android_app_spacehero.menu;

import ru.majestic.android_app_spacehero.menu.listeners.GameMenuVisibleListener;

public interface IGameMenu {
   
   public static final float MENU_ANIMATION_TIME = 1f;//In seconds

   public void       show           ();
   public void       hide           ();   
   public boolean    isMenuVisible  ();
   
   public void addGameMenuVisibleListener    (GameMenuVisibleListener gameMenuVisibleListener);
   public void removeGameMenuVisibleListener (GameMenuVisibleListener gameMenuVisibleListener);
   
}
