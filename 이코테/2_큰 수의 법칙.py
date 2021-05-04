N, M, K = map(int, input().split())
array = list(map(int, input().split()))

array.sort()
a = array[N-1]
b = array[N-2]
result = 0

while True:
  for i in range(K):
    if M == 0 :
      break
    else :
      result += a
      M -= 1
  if M == 0:
    break
  result += b
  M -= 1
print(result)
