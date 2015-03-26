package ru.majestic.android_app_spacehero.menu.animation.main;

import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.sprite.Sprite;

import ru.majestic.android_app_spacehero.menu.IGameMenu;
import ru.majestic.android_app_spacehero.menu.animation.MenuItemAnimationSkeleton;

public class StartGameButtonShowAnim extends MenuItemAnimationSkeleton {
   
   public StartGameButtonShowAnim(Sprite animatedObject, float startYPosition, float endYPosition) {
      super(animatedObject);              
      
      sequenceEntityModifier = new SequenceEntityModifier(
            new MoveYModifier(IGameMenu.MENU_ANIMATION_TIME, startYPosition, endYPosition));
      
      sequenceEntityModifier.addModifierListener(this);
   }
   
}
