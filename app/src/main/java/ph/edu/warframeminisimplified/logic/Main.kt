import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val warframeChoices = listOf(
        SealedWarframeChoices.EXCALIBUR,
        SealedWarframeChoices.MAG,
        SealedWarframeChoices.VOLT,
        SealedWarframeChoices.BANSHEE,
        SealedWarframeChoices.NOVA,
        SealedWarframeChoices.MIRAGE,
        SealedWarframeChoices.PROTEA,
    )
    val primaryWeaponChoices = listOf(
        PrimaryWeapon.BRATON,
        PrimaryWeapon.PARIS,
        PrimaryWeapon.FLUXRIFLE,
        PrimaryWeapon.HEK,
        PrimaryWeapon.KOMOREX,
        PrimaryWeapon.GLAXION,
    )
    val secondaryWeaponChoices = listOf(
        SecondaryWeapon.LATO,
        SecondaryWeapon.MAGNUS,
        SecondaryWeapon.DETRON,
        SecondaryWeapon.BRAKK,
        SecondaryWeapon.STUG,
    )
    var primaryWeapon: PrimaryWeapon = PrimaryWeapon.BRATON
    var secondaryWeapon: SecondaryWeapon
    while (true){
        var startInput: String?
        var warframeUserChoice: Int
        var primaryWeaponUserChoice: Int
        var secondaryWeaponUserChoice: Int
        print("Press any key to start and Esc to exit: ")
        startInput = readln()
            when(startInput){
                "\u001b" -> {
                    println("Exiting...")
                    return
                }
                else -> {
                    println("Choose your Warframe:")
                    warframeChoices.forEachIndexed { index, warframe ->
                        println("${index + 1}) ${warframe.name}")
                    }

                    warframeUserChoice = scanner.nextInt()

                    val warframeStats = warframeChoices.getOrNull(warframeUserChoice - 1)

                    if (warframeStats != null) {
                        val tenno = Tenno(
                            warframeStats.name,
                            warframeStats.healthTenno,
                            warframeStats.armorTenno,
                            warframeStats.shieldTenno,
                            warframeStats.speedTenno,
                            warframeStats.levelTenno,
                            warframeStats.currentXPTenno,
                            warframeStats.xpCapTenno

                        )
                        println("You have chosen ${tenno.name} as your Warframe.")
                        println("--------------------------------------------------------")
                        println("Choose your Primary Weapon:")
                        primaryWeaponChoices.forEachIndexed { index, weapon ->
                            println("${index + 1}) ${weapon.name}")
                        }
                        primaryWeaponUserChoice = scanner.nextInt()
                        val primaryWeaponStats = primaryWeaponChoices.getOrNull(primaryWeaponUserChoice - 1)
                        if (primaryWeaponStats != null) {
                                primaryWeapon = PrimaryWeapon(
                                primaryWeaponStats.name,
                                primaryWeaponStats.baseDamage,
                                primaryWeaponStats.multiShot,
                                primaryWeaponStats.fireRate,
                                primaryWeaponStats.criticalChance,
                                primaryWeaponStats.criticalDamage,
                                primaryWeaponStats.weaponAccuracy,
                                primaryWeaponStats.weaponRecoil,
                                primaryWeaponStats.weaponRange
                            )
                            println("You have chosen ${primaryWeaponStats.name} as your Primary Weapon.")
                            printWeaponStats(primaryWeaponStats)
                            println("")
                        } else {
                            println("Invalid choice. Please choose a valid Primary Weapon.")
                        }
                        println("Choose your Secondary Weapon:")
                        secondaryWeaponChoices.forEachIndexed { index, weapon ->
                            println("${index + 1}) ${weapon.name}")
                        }
                        secondaryWeaponUserChoice = scanner.nextInt()
                        val secondaryWeaponStats = secondaryWeaponChoices.getOrNull(secondaryWeaponUserChoice - 1)
                        if (secondaryWeaponStats != null) {
                                secondaryWeapon = SecondaryWeapon(
                                secondaryWeaponStats.name,
                                secondaryWeaponStats.baseDamage,
                                secondaryWeaponStats.multiShot,
                                secondaryWeaponStats.fireRate,
                                secondaryWeaponStats.criticalChance,
                                secondaryWeaponStats.criticalDamage,
                                secondaryWeaponStats.weaponAccuracy,
                                secondaryWeaponStats.weaponRecoil,
                                secondaryWeaponStats.weaponRange
                            )
                            println("You have chosen ${secondaryWeaponStats.name} as your Secondary Weapon.")
                            printWeaponStats(secondaryWeaponStats)
                            print("")
                            play(tenno, primaryWeapon, secondaryWeapon)
                        } else {
                            println("Invalid choice. Please choose a valid Secondary Weapon.")
                        }
                    }
                    else {
                        println("Invalid choice. Please choose a valid Warframe.")
                    }
                }
            }
    }
}

fun printWeaponStats(weapon: SealedRangedWeapons) {
    println("Base Damage: ${weapon.baseDamage}")
    println("MultiShot: ${weapon.multiShot}")
    println("Fire Rate: ${weapon.fireRate}")
    println("Critical Chance: ${weapon.criticalChance}%")
    println("Critical Damage: ${weapon.criticalDamage}")
    println("Weapon Accuracy: ${weapon.weaponAccuracy}%")
    println("Weapon Recoil: ${weapon.weaponRecoil}")
    println("Weapon Range: ${weapon.weaponRange}")
}

