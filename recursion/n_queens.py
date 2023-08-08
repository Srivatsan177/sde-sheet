import typing
from pprint import pprint
from copy import deepcopy


def is_safe(row: int, col: int, board: typing.List[typing.List[int]]) -> bool:
    # check row and col
    # print(board)
    row1 = row
    col1 = col
    while col1 >= 0:
        if board[row1][col1] == 1:
            return False
        col1 -= 1
    # check diagonal
    # lower diagonal
    row1 = row
    col1 = col
    while row1 < len(board) and col1 >= 0:
        if board[row1][col1] == 1:
            return False
        row1 += 1
        col1 -= 1
    # upper diagonal
    row1 = row
    col1 = col
    while row1 >= 0 and col1 >= 0:
        if board[row1][col1] == 1:
            return False
        row1 -= 1
        col1 -= 1
    return True


def n_queen(
    col: int,
    n: int,
    board: typing.List[typing.List[int]],
    solutions: typing.List[typing.Any],
) -> None:
    # print(col)
    if col == n:
        solutions.append(deepcopy(board))
        return
    for row in range(n):
        if is_safe(row, col, board):
            # print(row, col)
            board[row][col] = 1
            n_queen(col + 1, n, board, solutions)
            board[row][col] = 0


if __name__ == "__main__":
    n = int(input("board size"))
    solutions = []
    n_queen(0, n, [[0] * n for _ in range(n)], solutions)
    for i in solutions:
        for j in i:
            print(j)
        print()
