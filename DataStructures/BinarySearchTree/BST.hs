-- Haskell implementation of a Binary Search Tree
module BST
( Tree(..)
, singleton
, treeInsert
, treeElem
, treeFind
, treeDelete
) where

data Tree a = EmptyTree | Node a (Tree a) (Tree a) deriving (Show, Read, Eq)
singleton :: a -> Tree a
singleton x = Node x EmptyTree EmptyTree
treeInsert :: (Ord a) => a -> Tree a -> Tree a
treeInsert x EmptyTree = singleton x
treeInsert x (Node a left right)
    | x == a = Node x left right
    | x < a = Node a (treeInsert x left) right
    | x > a = Node a left (treeInsert x right)
treeElem :: (Ord a) => a -> Tree a -> Bool
treeElem x EmptyTree = False
treeElem x (Node a left right)
    | x == a = True
    | x < a = treeElem x left
    | x > a = treeElem x right
treeFind :: (Ord a) => a -> Tree a -> Tree a
treeFind x EmptyTree = EmptyTree
treeFind x (Node a left right)
    | x == a = Node a left right
    | x < a = treeFind x left
    | x > a = treeFind x right
minNode :: (Ord a) => Tree a -> a
minNode (Node a EmptyTree _) = a
minNode (Node a left _) = minNode left
treeDelete :: (Ord a) => a -> Tree a -> Tree a
treeDelete x EmptyTree = EmptyTree
treeDelete x (Node a left right)
    | x < a = Node a (treeDelete x left) right
    | x > a = Node a left (treeDelete x right)
    | x == a = deleteRoot $ Node a left right
    where deleteRoot (Node a EmptyTree right) = right
          deleteRoot (Node a left EmptyTree) = left
          deleteRoot (Node a left right) = Node minNodeRight left (treeDelete minNodeRight right)
          minNodeRight = minNode right

demoTree = foldr treeInsert EmptyTree [12,3,9,1,15,10,7,3]
