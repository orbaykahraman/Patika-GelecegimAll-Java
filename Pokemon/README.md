# Pokemon Game

Firstly, pokemon game is playing with 2 players. \
Each player enter his/her name and chooses character and pokemon in order. \
Then game picks random player to start first, and this player chooses his attack style. \
There are 3 attack style : normal, pokemon special attack(3 times), character special attack(1 time). \
If player selects special attack while he/she has no special attack left, his turn goes away with no effect. \
After every attack game picks random weather(get weather from WeatherEnum and picks randomly) which affects pokemons' damage. \
Also after every attack is done, game prints the remaining healths of pokemons.

When round 1 finishes, winner player's pokemon remains with current health,damage and also winner gets loser's pokemon with 100 health.Then winner chooses
one of these pokemons to play in round 2. \
Loser player gets weakest pokemon remaining in the main pokemon list based on damages.\
Game continiues 2 rounds, if players want to finish in the end of the round 1 they can finish the game.
