import java.util.*
import kotlin.random.Random

fun play(tenno: Tenno, primaryWeapon: PrimaryWeapon, secondaryWeapon: SecondaryWeapon) {
//    val enemies: List<Enemy> = listOf(CorpusTech(), CorpusAmalgamHeqet(), CorpusGlaxionMOA(), CorpusGlaxionMOA(), CorpusGlaxionMOA(), CorpusAmalgamHeqet())
//    val scanner = Scanner(System.`in`)
//    println("${tenno.name} vs. ${enemies.size} Corpus\n")
//    while (tenno.alive() && enemies.any { it.alive() }) {
//        val aliveEnemies = enemies.filter { it.alive() }
//        if (aliveEnemies.isNotEmpty()) {
//            val firstAliveEnemy = aliveEnemies.first()
//            println("\n")
//            println("Current Stats:")
//            println("Shields: ${tenno.shieldTenno}/${tenno.defaultShields} Health: ${tenno.healthTenno}/${tenno.defaultHealth}  Level: ${tenno.levelTenno} Current XP: ${tenno.currentXPTenno}/${tenno.xpCapTenno}")
//            println("\nOptions:")
//            println("1. Attack ${firstAliveEnemy.name} with ${primaryWeapon.name} for ${primaryWeapon.baseDamage * primaryWeapon.multiShot} - ${primaryWeapon.fireRate * (primaryWeapon.baseDamage * primaryWeapon.multiShot * primaryWeapon.criticalDamage)} damage ")
//            println("2. Attack ${firstAliveEnemy.name} with ${secondaryWeapon.name} for ${secondaryWeapon.baseDamage * secondaryWeapon.multiShot} - ${secondaryWeapon.fireRate * (secondaryWeapon.baseDamage * secondaryWeapon.multiShot * secondaryWeapon.criticalDamage)} damage ")
//            println("3. Dodge enemy attacks with ${tenno.speedTenno}% of success")
//            print("Enter your choice: ")
//            var shieldRegenCounter = 2
//            val choice = scanner.nextInt()
//
//            when (choice) {
//                1 -> {
//                    if (firstAliveEnemy.alive()) {
//                        val enemyMove = Random.nextInt(1, 101)
//                        println("${tenno.name} Attacking...")
//                        tenno.attack(firstAliveEnemy, primaryWeapon)
//                        println("\n")
//                        if ((enemyMove in 1..50) && firstAliveEnemy.alive()) {
//                            println("${firstAliveEnemy.name} Attacking...")
//                            firstAliveEnemy.attack(tenno, firstAliveEnemy.enemyWeapon)
//                        } else if((enemyMove in 51..101) && firstAliveEnemy.alive()) {
//                            println("${firstAliveEnemy.name} is regenerating shields...")
//                            firstAliveEnemy.shieldRegen()
//                            println("${firstAliveEnemy.name} has Shields: ${firstAliveEnemy.shieldEnemy}/${firstAliveEnemy.defaultShield} HP: ${firstAliveEnemy.healthEnemy}/${firstAliveEnemy.defaultHP}")
//                        }
//                        else {
//                            //tenno.currentXPTenno += firstAliveEnemy.xpProvidedEnemy
//                            //println("${tenno.name} gained ${firstAliveEnemy.xpProvidedEnemy} XP!")
//                            //tenno.levellingUp(tenno, primaryWeapon, secondaryWeapon)
//                        }
//                    }
//                    else {
//                        //tenno.currentXPTenno += firstAliveEnemy.xpProvidedEnemy
//                        //println("${tenno.name} gained ${firstAliveEnemy.xpProvidedEnemy} XP!")
//                        //tenno.levellingUp(tenno, primaryWeapon, secondaryWeapon)
//                    }
//                }
//                2 -> {
//                    if (firstAliveEnemy.alive()) {
//                        val enemyMove = Random.nextInt(1, 101)
//                        println("${tenno.name} Attacking...")
//                        tenno.attack(firstAliveEnemy, secondaryWeapon)
//                        println("\n")
//                        if ((enemyMove in 1..50) && firstAliveEnemy.alive()) {
//                            println("${firstAliveEnemy.name} Attacking...")
//                            firstAliveEnemy.attack(tenno, firstAliveEnemy.enemyWeapon)
//                        } else if((enemyMove in 51..101) && firstAliveEnemy.alive()) {
//                            println("${firstAliveEnemy.name} is regenerating shields...")
//                            firstAliveEnemy.shieldRegen()
//                            println("${firstAliveEnemy.name} has Shields: ${firstAliveEnemy.shieldEnemy}/${firstAliveEnemy.defaultShield} HP: ${firstAliveEnemy.healthEnemy}/${firstAliveEnemy.defaultHP}")
//                        }
//                        else{
//                            //tenno.currentXPTenno += firstAliveEnemy.xpProvidedEnemy
//                            //println("${tenno.name} gained ${firstAliveEnemy.xpProvidedEnemy} XP!")
//                            //tenno.levellingUp(tenno, primaryWeapon, secondaryWeapon)
//                        }
//                    }
//                    else {
//                       //tenno.currentXPTenno += firstAliveEnemy.xpProvidedEnemy
//                        //println("${tenno.name} gained ${firstAliveEnemy.xpProvidedEnemy} XP!")
//                        //tenno.levellingUp(tenno, primaryWeapon, secondaryWeapon)
//                    }
//                }
//
//                3 -> {
//                    if (firstAliveEnemy.alive()) {
//                        val dodgeMove = tenno.dodgeAttack(tenno.speedTenno, firstAliveEnemy)
//                        if (dodgeMove) {
//                            //println("${tenno.name} successfully dodged ${firstAliveEnemy.name}'s attack!\nNo damage received!")
//                            tenno.tennoShieldRegen()
//                           //println("${tenno.name} restoring shields to full...")
//                        } else {
//                            println("${tenno.name} failed to dodge the attack!")
//                            firstAliveEnemy.attack(tenno, firstAliveEnemy.enemyWeapon)
//                        }
//                    }
//                }
//            }
//            shieldRegenCounter -= 1
//        }
//    }
    if (tenno.alive()) {
        println("\n${tenno.name} wins!")
    } else {
        println("\n${tenno.name} was defeated. Game over!")
    }
}