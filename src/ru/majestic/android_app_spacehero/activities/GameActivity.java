package ru.majestic.android_app_spacehero.activities;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import ru.majestic.android_app_spacehero.andengine.GameCamera;
import ru.majestic.android_app_spacehero.andengine.GameEngineOptions;
import ru.majestic.android_app_spacehero.andengine.GameScene;
import ru.majestic.android_app_spacehero.menu.impl.MainMenu;
import ru.majestic.android_app_spacehero.resources.ResourceManager;


public class GameActivity extends BaseGameActivity {

   private Camera camera;
   
   private MainMenu mainMenu;
   
	@Override
	public EngineOptions onCreateEngineOptions() {
		camera = new GameCamera();
		
		return new GameEngineOptions(camera);
	}

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {
	   ResourceManager.getInstance().loadResources(getEngine(), this);
	   
	   mainMenu = new MainMenu();
	   
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {
		pOnCreateSceneCallback.onCreateSceneFinished(new GameScene());
	}

	@Override
	public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
	   mainMenu.setCamera(camera);
	   mainMenu.show();
	   
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}		

}
