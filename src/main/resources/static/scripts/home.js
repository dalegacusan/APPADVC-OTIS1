const startText = document.getElementById("start_text");
const currentWord = document.getElementById("current_word");
const textField = document.getElementById("text_field");
const time = document.getElementById("time");
const roundText = document.getElementById("round");
const scoreWrapper = document.getElementById("score_wrapper");
const score = document.getElementById("score");
const endGameScoreWrapper = document.getElementById("end_game_score_wrapper");
const endGameScore = document.getElementById("end_game_score");
const endGameRound = document.getElementById("end_game_round");
const scoreInput = document.getElementById("scoreInput");
const usernameInput = document.getElementById("usernameInput");
const roundInput = document.getElementById("roundInput");

// Words

const words = [
  "javascript",
  "stewardess",
  "zephyr",
  "sphinx",
  "australia",
  "integration",
  "startup",
  "difficult",
  "editor",
  "suburban",
  "assuming",
  "obstinance",
  "duck",
  "ethnicity",
  "wombat",
  "monopoly",
  "literally",
  "ironic",
  "irregardless",
  "colonel",
  "nonplussed",
  "disinterested",
  "enormity",
  "lieutenant",
  "seven",
  "keyboard",
  "juice",
  "lazy",
  "touch",
  "destination",
  "visual",
  "asset",
  "choir",
  "dvorak",
  "node",
  "deno",
  "yarn",
  "template",
  "index",
  "ignore",
  "social",
  "distance",
  "quarantine",
  "typewriter",
  "flagfalls",
  "polyphony",
  "skeuomorphism",
  "help",
  "socket",
  "now",
  "minimum",
  "language",
  "when",
  "pillow",
  "python",
  "snake",
  "banana",
  "word",
  "acceleration",
  "googol",
  "duffles",
  "fluffy",
  "daddy",
  "people",
  "which",
  "start",
  "number",
  "oh",
  "yeah",
  "why",
  "markup",
  "markdown",
  "typerapp",
  "soundboard",
  "shots",
  "pug",
  "jade",
  "normalize",
  "parcel",
  "bundler",
  "glob",
  "blob",
  "google",
  "apple",
  "microsoft",
  "yahoo",
  "duckduckgo",
  "bing",
  "firefox",
  "mozilla",
  "edge",
  "brave",
  "flutter",
  "native",
  "progressive",
  "terminal",
  "command",
  "mask",
  "studio",
  "capitals",
  "gist",
  "github",
  "penguin",
  "isthmus",
  "antarctic",
  "anathema",
  "singapore",
  "boston",
  "massachusetts",
  "commit",
  "handkerchief",
  "misspell",
  "interface",
  "roll",
  "train",
  "destroyer",
  "executor",
  "revenge",
  "devastator",
  "mississippi",
  "hawaii",
];

const state = {
  doneWords: [],
  currentWord: "",
  inGame: false,
  time: 0,
  score: 0,
  round: 1,
};

const gameLength = 10;
var interval;

window.addEventListener("load", () => {
  time.innerText = gameLength;
  roundText.innerText = state.round;

  textField.focus();
  textField.oninput = textFieldUpdate;

  // only show current word when game starts
  hide(currentWord);
  hide(endGameScoreWrapper);
});

const textFieldUpdate = () => {
  const text = textField.value.toLowerCase();

  if (!state.inGame && text === "start") startGame();

  // if word guessed correct, get an extra second
  if (state.inGame && text.trim() === state.currentWord) {
    round(1);
  }
};

const startGame = () => {
  hide(endGameScoreWrapper);
  endGameScore.innerText = 0;

  state.inGame = true;
  state.score = 0;

  // set game length
  time.innerText = gameLength;

  // start round
  round(gameLength);

  show(currentWord);
  hide(startText);

  interval = setInterval(() => {
    state.time--;
    time.innerText = state.time;
    if (state.time <= 0) {
      endGame();
    }
  }, 1000);
};

const round = (val) => {
  state.round += 1;
  roundText.innerText = state.round - 1;

  // clear the textfield
  textField.value = "";

  state.time = state.time + val;
  state.score += state.currentWord.length;
  score.innerText = state.score;

  // get random word
  while (true) {
    // if the word has already been given, don't give again
    state.currentWord = words[Math.floor(Math.random() * words.length)];

    if (!state.doneWords.includes(state.currentWord)) {
      break;
    }
  }

  currentWord.innerText = state.currentWord;
  textField.placeholder = state.currentWord;

  state.doneWords.push(state.currentWord);

  // if doneWords is the same size as words, empty it out
  // because otherwise there are no words left
  if (state.doneWords.length === words.length) {
    state.doneWords = [];
  }

  textField.focus();
};

const endGame = () => {
  // reset timer
  clearInterval(interval);

  state.inGame = false;
  state.time = 0;
  state.currentWord = "";
  state.doneWords = [];

  // show start text and change text
  show(startText);
  score.innerText = 0;
  roundText.innerText = 1;
  endGameScore.innerText = state.score;
  endGameRound.innerText = state.round - 1;
  scoreInput.value = state.score;
  usernameInput.value = "Maximus";
  roundInput.value = state.round - 1;
  show(endGameScoreWrapper);

  // set placeholder to "start" and empty textfield
  textField.placeholder = "start";
  textField.value = "";

  state.score = 0;
  state.round = 1;

  hide(currentWord);
};

// Utility Functions

const hide = (elem) => {
  elem.style.display = "none";
};

const show = (elem) => {
  elem.style.display = "block";
};
