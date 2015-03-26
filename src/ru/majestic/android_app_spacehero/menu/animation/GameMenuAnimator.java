package ru.majestic.android_app_spacehero.menu.animation;

import java.util.ArrayList;

import ru.majestic.android_app_spacehero.menu.animation.listeners.OnAnimationEndListener;


public class GameMenuAnimator {
   
   public interface OnMenuVisibleChangedListener {
      
      public void onShowMenuAnimationEnd();
      public void onHideMenuAnimationEnd();
      
   }
   
   private ArrayList<IMenuItemAnimation> showMenuAnimations = new ArrayList<IMenuItemAnimation>();
   private ArrayList<IMenuItemAnimation> hideMenuAnimations = new ArrayList<IMenuItemAnimation>();

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
      if(showMenuAnimations.isEmpty()) {
         menuItemAnimation.setOnAnimationEndListener(onShowAnimationEndListener);
      }
      
      showMenuAnimations.add(menuItemAnimation);
   }
   
   public void addHideAnimation(IMenuItemAnimation menuItemAnimation) {
      if(hideMenuAnimations.isEmpty()) {
         menuItemAnimation.setOnAnimationEndListener(onHideAnimationEndListener);
      }      
      
      hideMenuAnimations.add(menuItemAnimation);
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
   
}
