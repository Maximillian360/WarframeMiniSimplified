import kotlin.random.Random

val CorpusGlaxionMOA = Enemy(
    "Corpus MOA",
     Random.nextInt(30, 70),
     Random.nextInt(40, 80),
    2,
     Random.nextInt(30, 120),
    1,
    50,
    PrimaryWeapon.GLAXION,)