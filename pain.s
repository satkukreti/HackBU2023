.data
z: .asciiz"We will code in assembly"
.text
main:
  la $a0, z
  li $v0, 4
  syscall
