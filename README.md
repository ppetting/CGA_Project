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


