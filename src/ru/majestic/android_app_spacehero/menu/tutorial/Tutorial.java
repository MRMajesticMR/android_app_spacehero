package ru.majestic.android_app_spacehero.menu.tutorial;

import org.andengine.entity.primitive.Rectangle;

import ru.majestic.android_app_spacehero.resources.ResourceManager;

public class Tutorial extends Rectangle {

   //Hints views
   
   public Tutorial(float width, float height) {
      super(0, 0, width, height, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      setColor(0.0f, 0.0f, 0.0f);
      setAlpha(0.7f);
   }   
   
   public void show() {
      
   }
   
   
}
