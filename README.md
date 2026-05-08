# Play Again

A utility mod for Minecraft 1.8.9 (Forge) that automatically joins matches when it detects the `"CLICK HERE"` message in chat on the Mush server.

<img width="1600" height="900" alt="utility mod" src="https://github.com/user-attachments/assets/61b9094b-0d75-4118-bb48-d3fa3d2d07f7" />

## Important Note

This mod was developed to work **exclusively** on the **Mush** server.  
It listens for specific chat messages and automatically executes the queue/join action when detected.

Other servers are not supported.

## Requirements

* Minecraft **1.8.9**
* **Forge 1.8.9**
* **JDK 8** (for compiling)

---

# How to Build (Compile)

This project **strictly requires JDK 8**.

## Windows

1. Open CMD inside the project folder.
2. Set your Java 8 path.
3. Run the Gradle build command.

```bat
set "JAVA_HOME=C:\Program Files\Java\jdk1.8.0_xxx"
gradlew clean build
````

The compiled `.jar` file will be generated at:

```txt
build/libs/
```

## Linux

```bash
export JAVA_HOME=/path/to/jdk8
chmod +x gradlew
./gradlew clean build
```

---

# How to Install

1. Download the latest release from the releases page.
2. Place the `.jar` file inside your Minecraft `mods` folder.
3. Launch Minecraft using **Forge 1.8.9**.
4. Join the Mush server.
5. The mod will automatically detect and join matches when `"CLICK HERE"` appears in chat.

---

# Disclaimer

This project was created for educational purposes.
The author is not responsible for punishments, bans, or other consequences resulting from the use of this modification. Use at your own risk.

Minecraft modifications are allowed under Mojang's guidelines:

[https://help.minecraft.net/hc/en-us/articles/4409139065613-Mods-for-Minecraft-Java-Edition](https://help.minecraft.net/hc/en-us/articles/4409139065613-Mods-for-Minecraft-Java-Edition)
