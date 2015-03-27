package ru.majestic.android_app_spacehero.menu.animation.play;

import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.sprite.Sprite;

import ru.majestic.android_app_spacehero.menu.IGameMenu;
import ru.majestic.android_app_spacehero.menu.animation.MenuItemAnimationSkeleton;

public class PauseGameButtonHideAnim extends MenuItemAnimationSkeleton {
   
   public PauseGameButtonHideAnim(Sprite animatedObject, float startYPosition) {
      super(animatedObject);              
      
      sequenceEntityModifier = new SequenceEntityModifier(
            new MoveYModifier(IGameMenu.MENU_ANIMATION_TIME, startYPosition, -1000));           
   }
   
}
