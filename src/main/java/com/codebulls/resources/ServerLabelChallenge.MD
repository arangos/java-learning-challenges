### Java server names challenge

Physical servers used by our project are labeled using printed labels, with exactly one label
being attached to a server at any given time. Each label consists of an alphabetic host type (e.g.
"apibox") concatenated with the server number, with server numbers allocated sequentially (so,
the first label will be "apibox:1", next one "apibox:2", etc). As servers are provisioned and
deprovisioned, the labels get attached and detached; detached labels can later be reused for
the same host type.

We would like to keep the total number of labels printed to a minimum (we’re environmentally
friendly!). We would also like to maintain sequential numbering to the extent possible, so when
we need a label, we always pick the one with the lowest number.
Your task is to write a label tracking class with two operations, "attach(hostType)" and
"detach(label)". The former should return the next label to use, while the latter should return the
label back into the pool.

### For example:

```shell
const tracker = new Tracker();
tracker.attach("apibox");
"apibox:1"
tracker.attach("apibox");
"apibox:2"
tracker.detach("apibox:1");
tracker.attach("apibox");
"apibox:1"
tracker.attach("apibox");
"apibox:3"
tracker.detach("apibox:2");
tracker.attach("apibox");
"apibox:2"
tracker.attach("sitebox");
"sitebox:1"
```

