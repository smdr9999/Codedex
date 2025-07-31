import random,time
player_score = 0
computer_score = 0
#options=['✊','✋','✌️','🦎','🖖']
options = {
    1: "✊ Rock",
    2: "✋ Paper",
    3: "✌️ Scissors",
    4: "🦎 Lizard",
    5: "🖖 Spock"
}

win_conditions = {
  1: [3, 4],  # Rock beats Scissors, Lizard
  2: [1, 5],  # Paper beats Rock, Spock
  3: [2, 4],  # Scissors beats Paper, Lizard
  4: [2, 5],  # Lizard beats Paper, Spock
  5: [1, 3],  # Spock beats Rock, Scissors
}
ntr_quotes = [
  "🔥 Just like NTR in *War 2* — YOU DOMINATED the battlefield!",
  "💥 Victory roars like Komaram Bheem!",
  "🎯 Precision. Power. Pure NTR Energy!"
]
ntr_taunts = [
  "😈 Even NTR has tough battles... Train harder and strike again!",
  "🎬 NTR wouldn't quit — why should you?",
  "🏹 You just faced a setback — time to roar like a Komaram Bheem!",
]

def explain_win(winner, loser):
  actions = {
    (1, 3): "Rock crushes Scissors",
    (1, 4): "Rock crushes Lizard",
    (2, 1): "Paper covers Rock",
    (2, 5): "Paper disproves Spock",
    (3, 2): "Scissors cuts Paper",
    (3, 4): "Scissors decapitates Lizard",
    (4, 2): "Lizard eats Paper",
    (4, 5): "Lizard poisons Spock",
    (5, 1): "Spock vaporizes Rock",
    (5, 3): "Spock smashes Scissors"
  }
  return actions.get((winner, loser), "")

while True:
  print("\n🎬 It's a WAR between you and the computer —")
  print("    Bigger than the battle between Hrithik and NTR in *War 2*! 💥\n")
  print('''
  ================================
  Rock Paper Scissors Lizard Spock
  ================================

  1) ✊ Rock
  2) ✋ Paper
  3) ✌️ Scissors
  4) 🦎 Lizard
  5) 🖖 Spock
  ''')

  try:
    p=int(input("Pick a number: "))
    if p<1 or p>5:
      print("❗ Please choose a number between 1 and 5.")
      continue
  except ValueError:
    print("❗ Invalid input. Please enter a number.")
    continue
  print("You chose:", options[p])
  print("Computer is choosing", end="")
  for _ in range(3):
    print(".", end="", flush=True)
    time.sleep(0.4)

  c=random.randint(1,5)
  print("\nComputer chose:", options[c])
  if(p==c):
    print("Tie...choose again!")
    continue

  if c in win_conditions[p]:
    player_score += 1
    print("🎉 You won!")
    print(f"👉 {explain_win(p, c)}")
    print(random.choice(ntr_quotes))
  else:
    computer_score += 1
    print("💻 Computer won!")
    print(f"👉 {explain_win(c, p)}")
    print(random.choice(ntr_taunts))

  print("----------------------------------------------")
  print(f"🏆 Score — You: {player_score} | Computer: {computer_score}")
  again = input("Play again? (y/n): ").strip().lower()
  if again != 'y':
    print("==============================================")
    if player_score > computer_score:
      print("🏁 Final Result: YOU WON the War 2 Showdown! 🎉")
    elif player_score < computer_score:
      print("🏁 Final Result: Computer wins this battle... but War 2 isn't over! 💻")
    else:
      print("🏁 Final Result: It's a tie! The real War 2 continues... ⚔️")
    break
