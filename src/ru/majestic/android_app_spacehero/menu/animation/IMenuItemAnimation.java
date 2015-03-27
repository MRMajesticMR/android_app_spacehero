package ru.majestic.android_app_spacehero.menu.animation;

import ru.majestic.android_app_spacehero.menu.animation.listeners.OnAnimationEndListener;

public interface IMenuItemAnimation {
   
   public void    start                      ();   
   public void    setOnAnimationEndListener  (OnAnimationEndListener onAnimationEndListener);
   public float   getAnimationTime           ();
}
