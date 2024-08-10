class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Queue:
    def __init__(self):
        self.front = None
        self.rear = None
        self.size_queue = 0

    def enqueue(self, data):
        node = Node(data)
        if self.rear is None:
            self.front = node
            self.rear = node
        else:
            self.rear.next = node
            self.rear = node
        self.size_queue += 1

    def dequeue(self):
        if self.isEmpty():
            return None
        else:
            temp = self.front
            self.front = self.front.next
            if self.front is None:
                self.rear = None
            self.size_queue -= 1
            return temp.data

    def peek(self):
        if self.isEmpty():
            return None
        else:
            return self.front.data

    def isEmpty(self):
        return self.size_queue == 0

    def size(self):
        return self.size_queue

q = Queue()
print("Apakah queue kosong?", q.isEmpty())

q.enqueue("Apple")
q.enqueue("Banana")
q.enqueue("Cherry")

print("Ukuran queue:", q.size())
print("Data di depan queue:", q.peek())

print("Data yang dikeluarkan:", q.dequeue())
print("Data yang dikeluarkan:", q.dequeue())
print("Data yang dikeluarkan:", q.dequeue())

print("Apakah queue kosong?", q.isEmpty())