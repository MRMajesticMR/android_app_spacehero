package ru.majestic.android_app_spacehero.menu;

import ru.majestic.android_app_spacehero.menu.listeners.GameMenuVisibleListener;

public class MenuSwitcher implements GameMenuVisibleListener {
   
   private IGameMenu    currentMenu;
   private IGameMenu    nextMenu;
   
   public void switchMenuTo(IGameMenu gameMenu) {
      this.nextMenu = gameMenu;
      
      if(currentMenu == null) {
         gameMenu.addGameMenuVisibleListener(this);
         gameMenu.show();
      } else {
         currentMenu.addGameMenuVisibleListener(this);
         currentMenu.hide();
      }
   }
   
   public IGameMenu getCurrentMenu() {
      return currentMenu;
   }

   @Override
   public void onMenuShow() {
      nextMenu.removeGameMenuVisibleListener(this);
      currentMenu = nextMenu;
   }

   @Override
   public void onMenuHide() {
      currentMenu.removeGameMenuVisibleListener(this);
      nextMenu.addGameMenuVisibleListener(this);
      nextMenu.show();
   }
   
   
}
