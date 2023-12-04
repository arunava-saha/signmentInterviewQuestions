// String Comprassion ---- 1
// Function to perform string compression
function compress1(s) {
  const str = [];
  let count = 1;

  for (let i = 0; i < s.length; i++) {
    if (s[i] === s[i + 1]) {
      count++;
    } else {
      str.push(s[i] + count);
      count = 1;
    }
  }

  return str.join("");
}

// Bonus 1: Second compressor
function compress2(s) {
  let compressed = s[0];
  let count = s[1];

  for (let i = 2; i < s.length; i++) {
    if (count === s[i + 1]) {
      compressed += s[i];
    } else {
      compressed += count;
      compressed += s[i];
      count = s[i + 1];
    }
    i++;
  }
  compressed += s[s.length - 1];
  return compressed;
}

//  Is a digit (0 to 9) and returns true if it is, and false
const is_Int = (ch) => "0" <= ch && ch <= "9";

// Bonus 2: Decompressor
function decompress(s) {
  let output = "";
  for (let i = s.length - 1; i >= 0; ) {
    let span = 0;
    while (is_Int(s[i])) {
      if (span === 0) {
        span = Number(s[i]);
      } else {
        span = span + 10 * Number(str[i]);
      }
      --i;
    }

    // collect non-digits into the `output`, stop at the end or at a digit
    while (!is_Int(s[i])) {
      if (i === -1) break;
      output += s[i].repeat(span);
      --i;
    }
    if (i === -1) break;
  }

  return output.split("").reverse().join("");
}

// Test the code
// Testing function
function testCompression() {
  const testCases = [
    { input: "aabcccccaaa" },
    { input: "aabbcaaaccc" },
    { input: "abeefffcccwwqq" },
    { input: "aabbccddee" },
    { input: "abcabcxyzxyz" },
  ];

  for (const testCase of testCases) {
    const result1 = compress1(testCase.input);
    const result2 = compress2(result1);
    const result = decompress(result2);

    console.log(
      `Input: ${testCase.input}, Expected: ${testCase.input}, Result: ${result1} || ${result2} || ${result}`
    );
    console.assert(result === testCase.input, "Test failed!");
  }
}

testCompression();
