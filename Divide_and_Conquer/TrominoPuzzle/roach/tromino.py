def tromino(board, srow, scol, size, xrow, xcol):
    if(size == 1):
        return
    else:
        mrow = srow + size // 2
        mcol = scol + size // 2
        xrow1, xcol1 = 0, 0
        xrow2, xcol2 = 0, 0
        xrow3, xcol3 = 0, 0
        xrow4, xcol4 = 0, 0
        if(xrow < mrow and xcol < mcol):  # 1
            filterCenterException(board, mrow, mcol, 1)
            xrow1, xcol1 = xrow, xcol
        if(xrow < mrow and xcol >= mcol):  # 2
            ilterCenterException(board, mrow, mcol, 2)
            xrow2, xcol2 = xrow, xcol
        if(xrow > mrow and xcol < mcol):  # 3
            ilterCenterException(board, mrow, mcol, 3)
            xrow3, xcol3 = xrow, xcol
        if(xrow > mrow and xcol >= mcol):  # 4
            ilterCenterException(board, mrow, mcol, 4)
            xrow4, xcol4 = xrow, xcol
        tromino(board, srow, scol, size // 2, xrow1, xcol1)
        tromino(board, srow, scol, size // 2, xrow2, xcol2)
        tromino(board, srow, scol, size // 2, xrow3, xcol3)
        tromino(board, srow, scol, size // 2, xrow4, xcol4)


def filterCenterException(board, mrow, mcol, part):
    global tromino_count
    tromino_count += 1
    if(part != 1):
        board[mrow-1][mcol-1] = tromino_count
    if(part != 2):
        board[mrow-1][mcol] = tromino_count
    if(part != 3):
        board[mrow][mcol-1] = tromino_count
    if(part != 4):
        board[mrow][mcol] = tromino_count


def print_board(board):
    for i in range(m):
        for j in range(m):
            if(board[i][j] < 0):
                print("%3s" % "X", end="")
            print("%3d" % board[i][j], end="")
        print()
