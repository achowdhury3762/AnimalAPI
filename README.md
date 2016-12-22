Ashique Chowdhury
3303

The problem I encountered was accidentally setting my list's adapter to itself. After running a debugging check, I had realized that was my problem. Another problem that arised was getting a reference to the activity inside my adapter. At first I had passed in the activity from the adapter, but later realized it would be better to use a callback.
