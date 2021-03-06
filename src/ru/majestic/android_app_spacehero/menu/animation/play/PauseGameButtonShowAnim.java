package ru.majestic.android_app_spacehero.menu.animation.play;

import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.sprite.Sprite;

import ru.majestic.android_app_spacehero.menu.IGameMenu;
import ru.majestic.android_app_spacehero.menu.animation.MenuItemAnimationSkeleton;

public class PauseGameButtonShowAnim extends MenuItemAnimationSkeleton {
   
   public PauseGameButtonShowAnim(Sprite animatedObject, float endYPosition) {
      super(animatedObject);              
      
      sequenceEntityModifier = new SequenceEntityModifier(
            new MoveYModifier(IGameMenu.MENU_ANIMATION_TIME, -1000, endYPosition));           
   }
   
}
