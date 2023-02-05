(ns clo.core
  (:gen-class))

(defn determine-winner [user-choice computer-choice]
  (let [winning-combinations {
                              "rock" "scissor"
                              "paper" "rock"
                              "scissor" "paper"}
        user-winning-combination (winning-combinations user-choice)]
    (if (= user-winning-combination computer-choice)
        "Congratulations! You have won!"
        (if (= user-choice computer-choice)
          "It was a draw."
          "You have lost. Better luck next time."))
    )
  )

(defn start-game []
  (println "Please make a choice between 'rock', 'paper' and 'scissor'.")
  (let [choices ["rock" "paper" "scissor"]
        computer-choice (nth choices (rand-int 3))
        user-choice (read-line)
        game-result (determine-winner user-choice computer-choice)]
    (println "The computers choice: " computer-choice)
    (println "Your choice: " user-choice)
    (println game-result))
  )

(defn another-game []
  (println "Do you want to play again? (y/n)")
  (let [play-again (read-line)]
    (if (or (= play-again "y") (= play-again "Y"))
      (do
        (start-game)
        (recur))
      (println "Thank you for playing. Goodbye!"))))

(defn -main []
    (println "Welcome to Rock Paper Scissor!")
    (start-game)
    (another-game)
    )