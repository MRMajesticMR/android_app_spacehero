package ru.majestic.android_app_spacehero.menu.animation.main;

import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.sprite.Sprite;

import ru.majestic.android_app_spacehero.menu.IGameMenu;
import ru.majestic.android_app_spacehero.menu.animation.MenuItemAnimationSkeleton;

public class StartGameButtonShowAnim extends MenuItemAnimationSkeleton {

   private float startYPosition;
   private float endYPosition;
   
   public StartGameButtonShowAnim(Sprite animatedObject, float startYPosition, float endYPosition) {
      super(animatedObject);  
      
      this.startYPosition  = startYPosition;
      this.endYPosition    = endYPosition;
   }

   @Override
   protected void initModifiers(SequenceEntityModifier sequenceEntityModifier) {
      sequenceEntityModifier = new SequenceEntityModifier(
            new MoveYModifier(IGameMenu.MENU_ANIMATION_TIME, startYPosition, endYPosition));
   }

   
}
