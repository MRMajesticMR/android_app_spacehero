package ru.majestic.android_app_spacehero.menu.animation;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.modifier.IModifier;
import org.andengine.util.modifier.IModifier.IModifierListener;

import ru.majestic.android_app_spacehero.menu.animation.listeners.OnAnimationEndListener;

public abstract class MenuItemAnimationSkeleton implements IMenuItemAnimation, IModifierListener<IEntity> {

   protected   SequenceEntityModifier   sequenceEntityModifier;
   private     Sprite                   animatedObject;
   private     OnAnimationEndListener   onAnimationEndListener;
   
   public MenuItemAnimationSkeleton(Sprite animatedObject) {
      this.animatedObject = animatedObject;
   }      

   @Override
   public void start() {
      sequenceEntityModifier.reset();
      animatedObject.registerEntityModifier(sequenceEntityModifier);
   }
   
   @Override
   public void setOnAnimationEndListener(OnAnimationEndListener onAnimationEndListener) {
      this.onAnimationEndListener = onAnimationEndListener;
   }

   @Override
   public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {
      // .
      
   }

   @Override
   public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
      if(onAnimationEndListener != null)
         onAnimationEndListener.onAnimationEnd();     
   }
   
}
