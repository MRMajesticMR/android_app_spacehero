package ru.majestic.android_app_spacehero.activities;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import ru.majestic.android_app_spacehero.andengine.GameCamera;
import ru.majestic.android_app_spacehero.andengine.GameEngineOptions;
import ru.majestic.android_app_spacehero.andengine.GameScene;
import ru.majestic.android_app_spacehero.menu.MenuSwitcher;
import ru.majestic.android_app_spacehero.menu.impl.MainMenu;
import ru.majestic.android_app_spacehero.menu.impl.PlayMenu;
import ru.majestic.android_app_spacehero.menu.impl.PauseMenu;
import ru.majestic.android_app_spacehero.menu.listeners.MainMenuOnButtonsClickedListeners;
import ru.majestic.android_app_spacehero.menu.listeners.PauseMenuOnButtonsClickedListener;
import ru.majestic.android_app_spacehero.menu.listeners.PlayMenuOnButtonsClickedListener;
import ru.majestic.android_app_spacehero.resources.ResourceManager;
import android.view.KeyEvent;


public class GameActivity extends BaseGameActivity implements MainMenuOnButtonsClickedListeners,
                                                              PlayMenuOnButtonsClickedListener,
                                                              PauseMenuOnButtonsClickedListener {

   private Camera camera;
   
   private MenuSwitcher    menuSwitcher;
   
   private MainMenu        mainMenu;
   private PlayMenu        playMenu;
   private PauseMenu       pauseMenu;
   
   
	@Override
	public EngineOptions onCreateEngineOptions() {
		camera = new GameCamera();
		
		return new GameEngineOptions(camera);
	}

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {
	   ResourceManager.getInstance().loadResources(getEngine(), this);
	   
	   menuSwitcher = new MenuSwitcher();	
	   
	   mainMenu      = new MainMenu(camera);
	   playMenu      = new PlayMenu(camera);
	   pauseMenu     = new PauseMenu(camera);
	   	   
	   mainMenu.setMainMenuOnButtonsClickedListeners(this);
	   playMenu.setPlayMenuOnButtonsClickedListener(this);
	   pauseMenu.setPauseMenuOnButtonsClickedListener(this);
	   
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {
		pOnCreateSceneCallback.onCreateSceneFinished(new GameScene());
	}

	@Override
	public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
	   menuSwitcher.switchMenuTo(mainMenu);
	   
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}

   @Override
   public void onStartButtonClicked() {
      menuSwitcher.switchMenuTo(playMenu);
   }
   
   @Override
   public void onPauseButtonClicked() {
      menuSwitcher.switchMenuTo(pauseMenu);
   }
   
   @Override
   public void onResumeButtonClicked() {
      menuSwitcher.switchMenuTo(playMenu);
      
   }

   @Override
   public void onExitButtonClicked() {      
      menuSwitcher.switchMenuTo(mainMenu);
   }

   @Override
   public boolean onKeyDown(int keyCode, KeyEvent event) {
      if (keyCode == KeyEvent.KEYCODE_BACK) {
         if(menuSwitcher.getCurrentMenu() == mainMenu) {
            finish();
            return true;
         }
         
         if(menuSwitcher.getCurrentMenu() == playMenu) {
            menuSwitcher.switchMenuTo(mainMenu);
            return true;
         }                                    
         
         if(menuSwitcher.getCurrentMenu() == pauseMenu) {
            menuSwitcher.switchMenuTo(playMenu);
            return true;
         }
      }
      return super.onKeyDown(keyCode, event);
  }
   
}
