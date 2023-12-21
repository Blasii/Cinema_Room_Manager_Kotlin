package cinema

class Cinema(private val rows: Int, private val seats: Int) {
    private val cinemaSeats = MutableList(rows + 1) { MutableList(seats + 1) { Any() } }
    private var purchasedTickets = 0
    private var currentIncome = 0


    init {
        cinemaSeats[0][0] = ' '
        for (i in 1..rows) {
            cinemaSeats[i][0] = i
            for (j in 1..seats) {
                cinemaSeats[i][j] = 'S'
                cinemaSeats[0][j] = j
            }
        }
    }

    fun showSeats() {
        println("\nCinema:")
        for (row in cinemaSeats) {
            for (seat in row) {
                print("$seat ")
            }
            println()
        }
    }

    fun buyTicket(row: Int, seat: Int): Boolean {
        return try {
            if (cinemaSeats[row][seat] == 'B') {
                println("That ticket has already been purchased!")
                false
            } else if (row !in 1..rows || seat !in 1..seats) {
                false
            } else {
                val totalSeats = rows * seats
                val ticketPrice = if (totalSeats <= 60 || row <= rows / 2) 10 else 8

                println("Ticket price: $$ticketPrice")
                cinemaSeats[row][seat] = 'B'
                purchasedTickets++
                currentIncome += ticketPrice
                true
            }
        } catch (e: IndexOutOfBoundsException) {
            println("Wrong input!")
            false
        }
    }

    fun showStatistics() {
        val totalIncome =
            if (rows * seats <= 60) rows * seats * 10 else rows / 2 * seats * 10 + (rows - rows / 2) * seats * 8
        val percentage = purchasedTickets.toDouble() / (rows * seats) * 100

        println("\nNumber of purchased tickets: $purchasedTickets")
        println("Percentage: %.2f%%".format(percentage))
        println("Current income: $$currentIncome")
        println("Total income: $$totalIncome")
    }
}

