def hanoi_solver(n):
    # Initialize rods
    source = nums(range(n, 0, -1))
    auxiliary = []
    target = []

    moves = []

    # Helper to record the current state
    def record_state():
        moves.append(f"{source} {auxiliary} {target}")

    # Recursive Hanoi solver
    def move(disks, src, aux, tgt):
        if disks == 1:
            tgt.append(src.pop())
            record_state()
            return

        move(disks - 1, src, tgt, aux)
        tgt.append(src.pop())
        record_state()
        move(disks - 1, aux, src, tgt)

    # Record initial state
    record_state()

    # Solve the puzzle
    move(n, source, auxiliary, target)

    # Return formatted result
    return "\n".join(moves)

def max_min_avg(nums):
    max_val, min_val = nums[0], nums[0]
    avg = 0.0
    for i in range(len(nums)):
        if nums[i] > max_val:
            max_val = nums[i]

        if nums[i] < min_val:
            min_val = nums[i]

        avg += nums[i]

    avg = round(avg / len(nums), 2)

    return max_val, min_val, float(avg)

def count_even_odd(nums):
    even_count, odd_count = 0,0
    if len(nums) == 0:
        return

    for n in nums:
        if (nums[n] // 2) * 2 == nums[n]:
            even_count += 1
        else:
            odd_count += 1
    return even_count, odd_count

# def second_largest(nums):
#     largest = nums[0]
#     second_large = nums[0]
#     store = []
#
#     for n in nums:
#         if n > largest:
#             largest = n
#         else:
#             store.append(n)
#     for n in store:
#         if n > second_large:
#             second_large = n
#     return second_large

def second_largest(nums):
    if len(nums) < 2:
        return None

    largest = None # cant they be 0 or something
    second = None

    for n in nums:
        if largest is None or n > largest: # why do u need to check if largest is None
            if largest is not None and n != largest:
                second = largest
            largest = n

        elif n != largest and (second is None or n > second):# this is confusing
            second = n

    return second

def is_sorted(nums):
    for i in range(len(nums) - 1):
        if nums[i] > nums[i+1]:
            return True
        else:
            return False

def factorial(n):
    if n == 1 or n == 0:
        return
    return  n * factorial(n - 1)