# SplashScreen

> A Fabric mod that displays a customizable splash screen before Minecraft starts.

This repository is a maintained fork of [BertSa/SplashScreen](https://github.com/BertSa/SplashScreen). The original project and its author remain credited under the MIT license. This fork currently ports the mod to Minecraft 26.2.

## Features

- Shows a splash image while Minecraft is launching.
- Uses a custom image from `config/splashscreen/splash.png` when available.
- Supports the original image size, a multiplier, or precise width and height.
- Provides configuration through Mod Menu and Cloth Config.

## Compatibility

| Component | Version |
| --- | --- |
| Minecraft | 26.2 |
| Fabric Loader | 0.19.5 or newer |
| Fabric API | 0.159.0+26.2 |
| Java | 25 or newer |

Mod Menu and Cloth Config are required for the in-game configuration screen.

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/installer/) for Minecraft 26.2.
2. Install [Fabric API](https://modrinth.com/mod/fabric-api).
3. Download the latest `splashscreen-*.jar` from the [Releases](https://github.com/CelduinX/SplashScreen/releases) page.
4. Place the mod JAR in your Minecraft `mods` folder.

## Configuration

Open the settings through Mod Menu, or edit `config/splashscreen/option.json` directly:

```json
{
  "state": "Off",
  "multiplier": 1.0,
  "height": 200,
  "width": 500
}
```

The `state` can be `Off`, `Multiply`, or `Precise`. Place a PNG named `splash.png` in `config/splashscreen/` to replace the default image.

## Building from source

```bash
./gradlew build
```

On Windows, use `gradlew.bat build`. The compiled JARs are written to `build/libs/`.

## Credits and license

Original project: [BertSa/SplashScreen](https://github.com/BertSa/SplashScreen)

Fork repository: [CelduinX/SplashScreen](https://github.com/CelduinX/SplashScreen)

Licensed under the [MIT License](LICENSE.txt).
