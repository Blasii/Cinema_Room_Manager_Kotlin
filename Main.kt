package cinema

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()

    println("Enter the number of seats in each row:")
    val seats = readln().toInt()

    val cinema = Cinema(rows, seats)

    do {
        println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit")
        when (readln().toInt()) {
            1 -> cinema.showSeats()
            2 -> {
                var success: Boolean
                do {
                    println("\nEnter a row number:")
                    val reservedRow = readln().toInt()
                    println("Enter a seat number in that row:")
                    val reservedSeat = readln().toInt()
                    success = cinema.buyTicket(reservedRow, reservedSeat)
                } while (!success)
            }

            3 -> cinema.showStatistics()
            0 -> return
            else -> println("Invalid choice. Please enter 1, 2, 3 or 0.")
        }
    } while (true)
}