# Projektname
Moon Cruiser

# Teammitglieder
Listen Sie hier noch einmal alle Teammitglieder auf.
- Patrick Alexander Pettinger
- Sarah Elisabeth Jetz

# Featureliste

Alle Features wurden gemeinsam von den beiden Teammitgliedern implementiert. 

- Shader: Toonshader & Skyboxshader
- Carsteuerung über WASD
- Kamera-/Perspektivenwechsel über SHIFT-Taste
- Kollisionssystem zwischen Objekten der Spielwelt
  - Objekte: Car, Powerup, Debuff, Skybox, Ground
- Funktionierende Scheinwerfer (Ein- und Ausschaltbar über SPACE)
- Gameloop mit Win- und Losecondition 
  - Win: Alle Powerups eingesammelt
  - Lose: Alle Debuffs eingesammelt
- Powerups = zeitlich begrenzter Geschwindigkeitsbuff 
  - Ein Initialpowerup erscheint an einer zufälligen Position zum Start des Games. Danch wird beim Einsammeln eines Powerups ein Weiteres an einer zufälligen Stelle generiertes Powerup gespawnt. Das Ganze 10 mal.
- Debuff: zeitlich begrzenter Verlangsamungsdebuff
  - Initial werden fünf Debuffs an zufäliig generierten Orten initalisiert, welche um einen zufälligen Ort rotieren. 
- Beim einsammeln eines Powerups/Debuffs verschwindet das eingesammelte Objekt.
- Beim Versuch die Spielwelt zu verlassen, wird man um einen festen Wert zurück in die Spielewelt gesetzt.

# Quellen
- Carmodel: https://www.turbosquid.com/3d-models/3d-sports-car-cartoon-model-1505597
- Poweruptextur, Debufftextur, Skyboxtextur: https://gamebanana.com/mods/7919/
- Bodentexturen: https://as2.ftcdn.net/jpg/03/09/04/59/1000_F_309045980_zKAgyd8feCR69CMWQ1PlhCHhteODo9zd.jpg, https://64.media.tumblr.com/c837d602d357c38bb5df161de9fc121e/9bdffc009d2d9435-58/s2048x3072/cbe26c0eee59039b3d9f0b631d58d6f5a5843878.jpg
- Prinzipien: Blinn-Phong für Shader und Axis-Aligned Bounding Box für Collision
