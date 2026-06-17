

import numpy as np
prices = np.array([ [123, 345, 678], [458, 183, 640], [839, 207, 397], [739, 927, 548]])
returns = (prices[:,1:] / prices[:,:-1])
# print(returns)
# # [[2.80487805 1.96521739]
# #  [0.39956332 3.49726776]
# #  [0.24672229 1.9178744 ]
# #  [1.25439783 0.59115426]]
# mean_prices = np.mean(returns, axis=1)
# print(mean_prices)
# # [2.385-04772 1.94841554 1.08229834 0.92277605]
# votality_price = np.std(returns, axis=1)
# print(votality_price)
# # [0.41983033 1.54885222 0.83557605 0.33162179]
#
# weights = np.array([1,2.3, 0.5, 0.9])
# portfolio= np.dot(mean_prices, weights)# i noticed when i used regular returns it returned a value error
# print(portfolio)
# 8.23805107446319
sl= np.array([[2,3], [5,4]])
lk = (sl[:, 1:] / sl[:, :-1])
# print(lk)

menu = ['stewed meat with onions', 'bean soup', 'risotto with trout and shrimp',
       'fish soup with cream and onion', 'gyro']
menu.remove('bean soup')
print(menu)

menu.append('roasted beet salad')
print(menu)

num_customers = [137, 147, 135, 128, 170, 174, 165, 146, 126, 159,
                 141, 148, 132, 147, 168, 153, 170, 161, 148, 152,
                 141, 151, 131, 149, 164, 163, 143, 143, 166, 171]

avg_first_seven = sum(num_customers[:7]) // 7
avg_last_seven = sum(num_customers[-7:]) // 7
max_month = max(num_customers)
min_month = min(num_customers)

alphabet = "A.B.C.D.E.F.G.H.I.J.K.L.M.N.O.P.Q.R.S.T.U.V.W.X.Y.Z"
address = "Mr. H. Potter,The cupboard under the Stairs,4 Privet Drive,Little Whinging,Surrey"
letters = alphabet.split(".")
formatted_address = address.split(",")
print(letters, formatted_address)