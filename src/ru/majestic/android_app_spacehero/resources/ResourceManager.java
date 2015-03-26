package ru.majestic.android_app_spacehero.resources;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;

import android.content.Context;

public class ResourceManager {

   private static ResourceManager instance;
   
   private Engine engine;
   
   private BitmapTextureAtlas startGameBtnAtlas;
   
   private TiledTextureRegion startGameTextureRegion; 
   private TiledTextureRegion pauseGameTextureRegion;
   private TiledTextureRegion resumeGameTextureRegion;
   private TiledTextureRegion exitGameTextureRegion;
   
   
   private ResourceManager() {
      
   }
   
   public static synchronized ResourceManager getInstance() {
      if(instance == null)
         instance = new ResourceManager();
      
      return instance;
   }
   
   public void loadResources(Engine engine, Context context) {
      this.engine = engine;
      
      startGameBtnAtlas = new BitmapTextureAtlas(engine.getTextureManager(), 512, 512);
      
      startGameTextureRegion     = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(startGameBtnAtlas, context.getAssets(), "gfx/menu/main/start_btn.png", 0, 0, 2, 1);
      pauseGameTextureRegion     = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(startGameBtnAtlas, context.getAssets(), "gfx/menu/game/pause_btn.png", 0, 64, 2, 1);
      resumeGameTextureRegion    = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(startGameBtnAtlas, context.getAssets(), "gfx/menu/pause/resume_btn.png", 0, 128, 2, 1);
      exitGameTextureRegion      = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(startGameBtnAtlas, context.getAssets(), "gfx/menu/pause/exit_btn.png", 0, 172, 2, 1);
      
      startGameBtnAtlas.load();
   }
   
   public void unloadResources() {
      if(startGameBtnAtlas != null) {
         startGameBtnAtlas.unload();
         startGameBtnAtlas = null;
      }
   }
   
   public Engine getEngine() {
      return engine;
   }
   
   public TiledTextureRegion getStartGameBtnTextureRegion() {
      return startGameTextureRegion;
   }
   
   public TiledTextureRegion getPauseGameBtnTextureRegion() {
      return pauseGameTextureRegion;
   }

   public TiledTextureRegion getResumeGameTextureRegion() {
      return resumeGameTextureRegion;
   }

   public TiledTextureRegion getExitGameTextureRegion() {
      return exitGameTextureRegion;
   }      
   
}
