import os
import shutil

# Specify the directory path
rootdir = "./submissions"

# Get immediate subdirectories (one level down)
subdirs = [os.path.join(rootdir, name) for name in os.listdir(rootdir) if os.path.isdir(os.path.join(rootdir, name))]

# Loop through subdirectories
# Remove Wrong Answer and Time Limit Exceeded
for subdir in subdirs:
    # Print the subdirectory name
    print(f"Subdirectory: {subdir}")

    # Get immediate subdirectories (one level down)
    subsubdirs = [name for name in os.listdir(subdir) if os.path.isdir(os.path.join(subdir, name))]
    for subsubdir in subsubdirs:
        # Print the subsubdirectory name
        if subsubdir != "Accepted":
            directory_to_delete = os.path.join(subdir, subsubdir)
            print(f"deleting: {directory_to_delete}")
            shutil.rmtree(directory_to_delete)

# Remove empty directories
for root, dirs, files in os.walk(rootdir):
    # Check if the directory is empty (no files and no subdirectories)
    if not files and not dirs:
      # Remove the empty directory
      os.rmdir(root)
      print(f"Removed empty directory: {root}")