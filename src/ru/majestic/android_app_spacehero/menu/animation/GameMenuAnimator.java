package ru.majestic.android_app_spacehero.menu.animation;

import java.util.ArrayList;
import java.util.List;

import ru.majestic.android_app_spacehero.menu.animation.listeners.OnAnimationEndListener;


public class GameMenuAnimator {
   
   public interface OnMenuVisibleChangedListener {
      
      public void onShowMenuAnimationEnd();
      public void onHideMenuAnimationEnd();
      
   }
   
   private ArrayList<IMenuItemAnimation> showMenuAnimations = new ArrayList<IMenuItemAnimation>();
   private ArrayList<IMenuItemAnimation> hideMenuAnimations = new ArrayList<IMenuItemAnimation>();

   private IMenuItemAnimation    showAnimationWithListener;
   private IMenuItemAnimation    hideAnimationWithListener;
   
   
   private OnMenuVisibleChangedListener onMenuVisibleChangedListener;
   
   private OnAnimationEndListener onShowAnimationEndListener = new OnAnimationEndListener() {
      
      @Override
      public void onAnimationEnd() {
         onMenuVisibleChangedListener.onShowMenuAnimationEnd();
      }
   };
   
   private OnAnimationEndListener onHideAnimationEndListener = new OnAnimationEndListener() {
      
      @Override
      public void onAnimationEnd() {
         onMenuVisibleChangedListener.onHideMenuAnimationEnd();
      }
   };
   
   public void setOnMenuVisibleChangedListener(OnMenuVisibleChangedListener onMenuVisibleChangedListener) {
      this.onMenuVisibleChangedListener = onMenuVisibleChangedListener;
   }
   
   public void addShowAnimation(IMenuItemAnimation menuItemAnimation) {
      showMenuAnimations.add(menuItemAnimation);
      
      if(showAnimationWithListener != null)
         showAnimationWithListener.setOnAnimationEndListener(null);
      
      IMenuItemAnimation animationWithLogestDuration = getAnimationWithLogestDuration(showMenuAnimations);
      showAnimationWithListener = animationWithLogestDuration;
      showAnimationWithListener.setOnAnimationEndListener(onShowAnimationEndListener);           
   }
   
   public void addHideAnimation(IMenuItemAnimation menuItemAnimation) {            
      hideMenuAnimations.add(menuItemAnimation);
      
      if(hideAnimationWithListener != null)
         hideAnimationWithListener.setOnAnimationEndListener(null);
      
      IMenuItemAnimation animationWithLogestDuration = getAnimationWithLogestDuration(hideMenuAnimations);
      hideAnimationWithListener = animationWithLogestDuration;
      hideAnimationWithListener.setOnAnimationEndListener(onHideAnimationEndListener);
   }

   public void show() {
      for(IMenuItemAnimation anim: showMenuAnimations) {
         anim.start();
      }
   }
   
   public void hide() {
      for(IMenuItemAnimation anim: hideMenuAnimations) {
         anim.start();
      }
   }
   
   private IMenuItemAnimation getAnimationWithLogestDuration(List<IMenuItemAnimation> animations) {
      IMenuItemAnimation result = animations.get(0);
      for(IMenuItemAnimation anim: animations) {
         if(anim.getAnimationTime() > result.getAnimationTime())
            result = anim;
      }
      
      return result;
   }
   
}
