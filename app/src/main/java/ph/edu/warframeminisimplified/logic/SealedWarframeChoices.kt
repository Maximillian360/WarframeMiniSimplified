import kotlin.random.Random

sealed class SealedWarframeChoices(
    val name: String,
    val healthTenno: Int,
    val armorTenno: Int,
    val shieldTenno: Int,
    val speedTenno: Int,
    val levelTenno: Int = 1,
    val currentXPTenno: Int,
    val xpCapTenno: Int,

    ){
    object EXCALIBUR : SealedWarframeChoices("Excalibur", Random.nextInt(150,200), 20, Random.nextInt(150,200), Random.nextInt(50, 75), 1, 0,100)
    object MAG : SealedWarframeChoices("Mag", Random.nextInt(150,200),  10, Random.nextInt(150,200),Random.nextInt(42, 70),1, 0,100)
    object VOLT : SealedWarframeChoices("Volt", Random.nextInt(150,200),  12,Random.nextInt(150,200),Random.nextInt(65, 90),1, 0,100)
    object BANSHEE : SealedWarframeChoices("Banshee", Random.nextInt(150,200), 10,Random.nextInt(150,200), Random.nextInt(50, 80),1, 0,100)
    object NOVA : SealedWarframeChoices("Nova", Random.nextInt(150,200),  15,Random.nextInt(150,200), Random.nextInt(40, 72),1, 0,100)
    object MIRAGE : SealedWarframeChoices("Mirage", Random.nextInt(150,200),  25,Random.nextInt(150,200), Random.nextInt(75, 80),1, 0,100)
    object PROTEA : SealedWarframeChoices("Protea", Random.nextInt(150,200), 35,Random.nextInt(150,200), Random.nextInt(60, 80),1, 0,100)
    object WUKONG : SealedWarframeChoices( "Wukong", Random.nextInt(150,200), 32,Random.nextInt(150,200), Random.nextInt(60, 80),1, 0,100)
}