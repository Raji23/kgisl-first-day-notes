public boolean deleteBook(Book book) throws SQLException {
    String sql = "DELETE FROM booklist where book_id = ?";
     
    connect();
     
    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, book.getId());
     
    boolean rowDeleted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowDeleted;     
}