# Huffman encoding algorithm implementation

## About

This repository contains a Java implementation of the Huffman coding algorithm for data compression. The program reads a variable-length text input from the console, constructs a Huffman tree, and outputs the encoded text along with the original message. This project demonstrates an efficient method for lossless data compression.

## Features

- Reads text input from the console
- Calculates character frequencies
- Constructs a Huffman tree
- Generates Huffman codes for each character
- Encodes the input text using Huffman codes
- Decodes the encoded text to the original message

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/MatiasCarabella/huffman-encoding.git
    ```
2. Navigate to the project directory:
    ```bash
    cd huffman-encoding
    ```

### Usage

1. Compile the Java program:
    ```bash
    javac huffman-encoding.java
    ```
2. Run the program:
    ```bash
    java huffman-encoding
    ```
3. Enter the text you wish to compress when prompted.

### Example
  ```
  Ingrese el texto a comprimir:
  estamos bien
  
  Codificación de Huffman:
  a: 111
  b: 010
  e: 00
  i: 0111
  m: 1101
  n: 0110
  o: 101
  s: 1100
  t: 100
  
  Texto original: estamos bien
  Texto codificado: 100111110010011000110110100111
  Texto decodificado: estamos bien
  ```
## Files

- `huffman-encoding.java`: Main Java file containing the implementation of Huffman coding algorithm.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Based on the Huffman coding algorithm for efficient data compression.
